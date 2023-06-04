const express = require('express');
const app = express();

const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// setup handlebars view engine
const handlebars = require('express-handlebars');
app.engine('handlebars', handlebars({}));
app.set('view engine', 'handlebars');


// Use the zipCode module
const pm = require('./projectModule');

// Implement the JSON, XML, & HTML formats

app.get('/project/:id', (req, res) => {
	const id = req.params.id;
	const result = pm.lookupByProjectId(id);

	res.format({
		// render as JSON
		'application/json': function () {
			res.json(result);
		},

		// render as XML
		'application/xml': function () {
			let resultXml = 
				'<?xml version="1.0"?>\n' +
				'<projectName="' + result.projectName + '">\n' +
					' <projectId>"' + result.projectId + '"</projectId>\n' +
					' <employees>"' + result.employees + '"</employees>\n' + 
				'</projectName>\n';
			
			res.type('application/xml');
			res.send(resultXml);
		},

		// render as HTML
		'text/html': function () {
			res.render('projectView', result);
		}
	});
});

app.listen(3000, () => {
  console.log('http://localhost:3000');
});




