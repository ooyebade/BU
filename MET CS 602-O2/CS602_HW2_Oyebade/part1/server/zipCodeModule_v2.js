// Copy your solution from Assignment1


let data = require('./zips.json');

module.exports.lookupByZipCode =  (zip) => {
    // items represent the data array
    let items = data;
    // result will store the object from items where _id property is same as zip
    const result = items.find(item => item._id === zip);
    // return the result value if data matches the specified argument or return undefined 
        return result ? result: undefined;
};

module.exports.lookupByCityState = (city, state) => {
    // items represent the data array
    let items = data;
	const result = items
        // filter all data from array
        .filter(item => item.city === city && item.state === state)
        // map through the result 
        .map(item => {
            // return the object with zip and pop props
            return {zip: item._id, pop: item.pop}
        })
    // return the object with city, state, and data props
    return {city, state, data:result };
};

module.exports.getPopulationByState = (state) => {
    // items represent the data array
    let items = data;
    // reduce accumulates and gives one value
    // using the reducer function, we check...
    let totalPop = items.reduce((acc, curr) => {
        // whether current value has state prop same as input argument
        if (curr.state === state) {
            // add value of pop prop of the object to accumulator
            acc += curr.pop;
        }
        // return accumulate value
        return acc;
    }, 0) // 0 is initializing the value of accumulator acc
    // return state and pop props object
    return {state, pop: totalPop };
};
