const express = require('express');
const app = express();

const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

// setup handlebars view engine
const handlebars = require('express-handlebars');

app.engine('handlebars', 
	handlebars({defaultLayout: 'main'}));

app.set('view engine', 'handlebars');

// static resources
app.use(express.static(__dirname + '/public'));

// Use the employee module
const cities = require('./mongo_zipCodeModule_v2');

// GET request to the homepage

app.get('/', function (req, res){
	res.render('homeView');
});

app.get('/zip', async function(req, res) {
	if (req.query.id) {
		let id = req.query.id;
		let result = await cities.lookupByZipCode(id);
		res.render('lookupByZipView', result);
	} else {
		res.render('lookupByZipForm');
	}
});

app.post('/zip', async function(req, res) {
	let id = req.body.id;
	let result = await cities.lookupByZipCode(id);
	res.render('lookupByZipView', result);
});


app.get('/zip/:id', async function(req, res) {
	let id = req.params.id;
	let result = await cities.lookupByZipCode(id);

	res.format({

		'application/json': function() {
			res.json(result);
		},

		'application/xml': function() {
			let resultXml = 
				'<?xml version="1.0"?>\n' +
					'<zipCode id="' + result._id + '">\n' + 
					'   <city>' + result.city + '</city>\n' + 
					'   <state>' + result.state + '</state>\n' + 	
					'   <pop>' + result.pop + '</pop>\n' + 				 
					'</zipCode>\n';
					
			
			res.type('application/xml');
			res.send(resultXml);
		},

		'text/html': function() {
			res.render('lookupByZipView', result);

		}
	});
});


// Complete the code for the following

app.get('/city', async function(req, res){
	let city = req.query.city;
	let state = req.query.state;
	if (city && state) {
		let result = await cities.lookupByCityState(city, state);
		res.render('lookupByCityStateView', result);
	} else {
		res.render('lookupByCityStateForm');
	}
});

app.post('/city', async function(req, res){
	// looking up the corresponding data for request 'body' state & city parameter
	let city = req.body.city;
	let state = req.body.state;
	let result = await cities.lookupByCityState(city, state);
	// render the 'lookupByCityStateView'
	res.render('lookupByCityStateView', result);

});

app.get('/city/:city/state/:state', async function(req, res) {
	const city = req.params.city;
	const state = req.params.state;
	const result = await cities.lookupByCityState(city, state);

	res.format ({
		// render as JSON
		'application/json': function () {
			res.json(result);
		},

		// render as XML
		'application/xml': function () {
			let resultXml = 
				'<?xml version="1.0"?>\n' +
				' <city-state city="' + result.city + '"\n' +
					' <state="' + result.state + '">\n' + 
					' <entry zip="' + result._id + '" \n' +
					' <pop="' + result.pop +'"/>' +
				'</city-state>\n';
				
			res.type('application/xml');
			res.send(resultXml);
		},

		// render as HMTL
		'text/html': function () {
			res.render('lookupByCityStateView', result);
		}
	});	

});

app.get('/pop', async function(req, res) {
	// using the if statement to lookup corresponding data
	// if request query 'state' is present
	let state = req.query.state;
	if (state) {
		let result = await cities.getPopulationByState(state);
		// render the 'populationView page'
		return res.render('populationView', result);
	} else {
		res.render('populationForm');
	}
	
});

app.get('/pop/:state', async function(req, res) {
	let state = req.params.state;
	let result = await cities.getPopulationByState(state);

	res.format({
		// render as JSON
		'application/json': function () {
			res.json(result);
		}, 

		// render as XMl
		'application/xml': function () {
			let resultXml =
				'<?xml version="1.0"?>\n' +
				'<state-pop state="' + result.state + '">\n' +
					'<pop>"' + result.pop + '</pop>\n' +
				'</state-pop>\n';

			res.type('application/xml');
			res.send(resultXml);
		}, 

		// render as HTML
		'text/html': function () {
			res.render('populationView', result);
		}
	});

});


app.use((req, res) => {
	res.status(404);
	res.render('404');
});

app.listen(3000, () => {
  console.log('http://localhost:3000');
});




