const cities = require('./mongo_zipCodeModule_v2');

const colors = require('colors');

(async () => {

	console.log(colors.red("\nLookup by zip code (02215)"));
	let result1 = await cities.lookupByZipCode('02215');
	console.log(result1);

	console.log(colors.red("\nLookup by zip code (99999)"));
	let result2 = await cities.lookupByZipCode('99999');
	console.log(result2);


	console.log(colors.red("\nLookup by city (BOSTON, MA)"));
	let result3 = await cities.lookupByCityState('BOSTON', 'MA');
	console.log(result3);


	console.log(colors.red("\nGet Population by State (MA)"));
	let result4 = await cities.getPopulationByState('MA');
	console.log(result4);
 
	process.exit();

})();
