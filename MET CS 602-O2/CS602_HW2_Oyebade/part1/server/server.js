const net = require('net');

const colors = require('colors');

const cities = require('./zipCodeModule_v2');

const server = net.createServer((socket) => {

	console.log("Client connection...".red);

	socket.on('end', () => {
		console.log("Client disconnected...".red);
	});

	// HW Code - Write the following code to process data from client
	
	socket.on('data', (data) => {

		let input = data.toString().split(",");

		// Fill in the rest

		// execute the function that the client called
		switch (input[0]) {
			case 'lookupByZipCode':
				console.log(colors.blue("...Received lookupByZipCode,"+input[1]));
				try {
					zipCode = JSON.stringify(cities.lookupByZipCode(input[1]));
					socket.write(zipCode);
				} catch {
					socket.write(colors.red("Opps...Zip Code doesn't exist!"));
				}
				break;
			
			case 'lookupByCityState':
				console.log(colors.blue("...Received lookupByCityState,"+input[1]+" "+input[2]));
				cityState = JSON.stringify(cities.lookupByCityState(input[1], input[2]));
				socket.write(cityState);
				break;
			
			case 'getPopulationByState':
				console.log(colors.blue("...Received getPopulationByState,"+input[1]));
				popState = JSON.stringify(cities.getPopulationByState(input[1]));
				socket.write(popState);
				break;
			default:
				socket.write("Invalid request");
		}
	});

});

// listen for client connections
server.listen(3000, () => {
	console.log("Listening for connections on port 3000");
});
