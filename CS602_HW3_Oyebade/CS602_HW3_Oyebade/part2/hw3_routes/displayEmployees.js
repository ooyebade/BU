const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

// display employees

module.exports = async (req , res , next) => {

        let employees = await Employee.find({});

        let results = employees.map( employee => {
            return {
                id: employee._id,
                firstName: employee.firstName,
                lastName: employee.lastName
            }
        });
            
        res.render('displayEmployeesView',
                {title:"List of Employees", data:results});
        
};
