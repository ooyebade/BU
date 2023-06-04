const EventEmitter = require('events').EventEmitter;

// const { EventEmitter } = require('events');
const data = require('./zips.json');

// Custom class 
class ZipCodeEmitter  extends EventEmitter {
	
	// member functions

	lookupByZipCode(zip)  {
		for(let item of data) {
			if (item._id === zip) {
				this.emit('lookupByZipCode', item);
			}
		}
	}

	lookupByCityState(city, state)  {
		// array to store filtered zip and pop of the objects
		const filteredData = [];
		// loop over the objects in data array
		for (let item of data) {
			// check to see if both city and state value of current object is equal to passed arguments
			if (item.city === city && item.state === state) {
				// add items to the array of filteredData
				filteredData.push({ zip: item._id, pop: item.pop })
			}
		}
		this.emit('lookupByCityState', {city, state, Data:filteredData});
	}

	getPopulationByState(state) {
		// initialize the total population to 0
		let totalPop = 0;
    	// loop over the objects in data array
    	for (let item of data) {
        	// check to see if state value of current object is = to passed argument
        	if (item.state === state) {
            	// add current object of population to total population
            	totalPop += item.pop
        	}
		}
    	this.emit('getPopulationByState', {state, pop:totalPop});
	}

}

module.exports.ZipCodeEmitter = ZipCodeEmitter;

