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

// Use the zipCode module
const cities = require('./zipCodeModule_v2');

// GET request to the homepage

app.get('/',  (req, res) => {
	res.render('homeView');
});

app.get('/zip', (req, res) => {
	// using the if statement to lookup corresponding data
	// if request query 'id' is present
	const id = req.query.id;
	if (id) {
		const result = cities.lookupByZipCode(id);
		// render the 'lookupByZipView' page
		res.render('lookupByZipView', {
			zipVar: result._id,
			city: result.city,
			state: result.state,
			pop: result.pop
		});
	} else {
		res.render('lookupByZipForm');
	}
});

app.post('/zip', (req, res) => {
	// looking up the corresponding data for request 'body' id parameter
	const id = req.body.id;
	const result = cities.lookupByZipCode(id);
	// render the 'lookupByZipView'
	res.render('lookupByZipView', {
		zipVar: result._id,
		city: result.city,
		state: result.state,
		pop: result.pop
	});
});

// Implement the JSON, XML, & HTML formats

app.get('/zip/:id', (req, res) => {
	const id = req.params.id;
	const result = cities.lookupByZipCode(id);

	res.format({
		// render as JSON
		'application/json': function () {
			res.json(result);
		},

		// render as XML
		'application/xml': function () {
			let resultXml = 
				'<?xml version="1.0"?>\n' +
				'<zipCode id="' + result._id + '">\n' +
					' <city>"' + result.city + '"</city>\n' +
					' <state>"' + result.state + '"</state>\n' + 
					' <pop> "' + result.pop +'"</pop>' +
				'</zipCode>\n';
			
			res.type('application/xml');
			res.send(resultXml);
		},

		// render as HTML
		'text/html': function () {
			res.render('lookupByZipView', result);
		}
	});
});

app.get('/city', (req, res) => {
	// using the if statement to lookup corresponding data
	// if request query 'city' and 'state' is present
	const city = req.query.city;
	const state = req.query.state;
	if (city && state) {
		const result = cities.lookupByCityState(city, state);
		// render the 'lookupByCityStateView page'
		res.render('lookupByCityStateView', {
			cityVar: result.city,
			stateVar: result.state,
			data: result.data
		});
	} else {
		res.render('lookupByCityStateForm');
	}
});

app.post('/city', (req, res) => {
	// looking up the corresponding data for request 'body' state & city parameter
	const city = req.body.city;
	const state = req.body.state;
	const result = cities.lookupByCityState(city, state);
	// render the 'lookupByCityStateView'
	res.render('lookupByCityStateView', {
		cityVar: result.city,
		stateVar: result.state,
		data: result.data
	});

});

// Implement the JSON, XML, & HTML formats

app.get('/city/:city/state/:state', (req, res) => {
	const city = req.params.city;
	const state = req.params.state;
	const result = cities.lookupByCityState(city, state);
	const output = result.data;

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
					' <entry zip="' + output + '" \n' +
					' <pop="' + output +'"/>' +
				'</city-state>\n';
				
			res.type('application/xml');
			res.send(resultXml);
		},

		// render as HMTL
		'text/html': function () {
			res.render('lookupByCityStateView', {
				stateVar: result.state,
				data: result.data
			});
		}
	});
});

app.get('/pop', (req, res) => {
	// using the if statement to lookup corresponding data
	// if request query 'state' is present
	const state = req.query.state;
	if (state) {
		let result = cities.getPopulationByState(state);
		// render the 'populationView page'
		return res.render('populationView', {
			state: result.state, pop: result.pop
		});
	} else {
		res.render('populationForm');
	}
});

// Implement the JSON, XML, & HTML formats

app.get('/pop/:state', (req, res) => {

	const state = req.params.state;
	const result = cities.getPopulationByState(state);

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
			res.render('populationView', {
				state: result.state,
				pop: result.pop
			});
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




