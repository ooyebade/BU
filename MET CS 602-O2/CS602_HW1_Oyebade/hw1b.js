const cities = require('./zipCodeModule_v2');
const colors = require('colors');

console.log(colors.red("\nLookup by zip code (02215)"));
console.log(cities.lookupByZipCode("02215"));

console.log(colors.red("\nLookup by zip code (99999)"));
console.log(cities.lookupByZipCode("99999"));

console.log(colors.red("\nLookup by city (BOSTON, MA)"));
console.log(cities.lookupByCityState("BOSTON", "MA"));

console.log(colors.red("\nLookup by city (BOSTON, TX)"));
console.log(cities.lookupByCityState("BOSTON", "TX"));

console.log(colors.red("\nLookup by city (BOSTON, AK)"));
console.log(cities.lookupByCityState("BOSTON", "AK"));

console.log(colors.red("\nGet Population by State (MA)"));
console.log(cities.getPopulationByState("MA"));

console.log(colors.red("\nGet Population by State (TX)"));
console.log(cities.getPopulationByState("TX"));

console.log(colors.red("\nGet Population by State (AA)"));
console.log(cities.getPopulationByState("AA"));
