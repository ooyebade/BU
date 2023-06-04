const data = require('./zips.json');

module.exports.lookupByZipCode =  (zip) => {
    // loop over the objects in data array
    for(let item of data) {
        // check to see if _id value of current object is equal to zip value
        if (item._id === zip) {
            // return object if values are the same
            return item;
        }
    }
    // return undefined if specified argument is not present
    return undefined;
};

module.exports.lookupByCityState = (city, state) => {
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
    return {city, state, data:filteredData};
};

module.exports.getPopulationByState = (state) => {
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
    return {state, pop:totalPop};
};

