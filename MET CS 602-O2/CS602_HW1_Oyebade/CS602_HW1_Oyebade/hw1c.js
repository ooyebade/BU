const colors = require('colors');

const ZipCodeEmitter = require('./zipCodeEmitter').ZipCodeEmitter;

const cities = new ZipCodeEmitter();

cities.on('lookupByZipCode', function (item) {
    console.log(colors.blue('\nEvent lookupByZipCode raised!\n %s'), item);
});

cities.on('lookupByCityState', function (args) {
    console.log(colors.blue('\nEvents lookupByCityState raised! (Handler 1)'));
    console.dir(args);
});

cities.on('lookupByCityState', function () {
    console.log(colors.blue('\nEvents lookupByCityState raised! (Handler 2)'));

});

cities.on('getPopulationByState', function (state) {
    console.log(colors.blue('\nEvents getPopulationByState raised!\n %s'), state);
})

console.log("\nlookup by zip code (02215)".red);
cities.lookupByZipCode('02215');

console.log("\nlookup by city (BOSTON, MA)".red);
cities.lookupByCityState('BOSTON', 'MA');

console.log("\nGet population by State (MA)".red);
cities.getPopulationByState('MA');

