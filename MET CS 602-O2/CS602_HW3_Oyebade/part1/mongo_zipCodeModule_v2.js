const MongoClient = require('mongodb').MongoClient;
const credentials = require("./credentials.js");

const dbUrl = 'mongodb+srv://' + credentials.username +
	':' + credentials.password + '@' + credentials.host + '/' + credentials.database;

let client = null;

const getConnection = async () => {
	if (client == null)
		client = await MongoClient.connect(dbUrl,  { useNewUrlParser: true ,  useUnifiedTopology: true });
	return client;
}

module.exports.lookupByZipCode =  async (zip) => {
		
	let client = await getConnection();
	let collection = client.db(credentials.database).collection('zipcodes');
	
	let result = await collection.find({'_id': zip}).toArray();
	
	if (result.length > 0)
		return result[0];
	else
		return undefined;
};

// Complete the code for the following

module.exports.lookupByCityState = async (city, state) => {

	let client = await getConnection();
	let collection = client.db(credentials.database).collection('zipcodes');
	
	// Fill in the rest	
	let items = await collection.find({'city': city, 'state': state}).toArray();
	
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


module.exports.getPopulationByState = async (state) => {

	let client = await getConnection();
	let collection = client.db(credentials.database).collection('zipcodes');
	
	// Fill in the rest
	let items = await collection.find({'state': state}).toArray();
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

