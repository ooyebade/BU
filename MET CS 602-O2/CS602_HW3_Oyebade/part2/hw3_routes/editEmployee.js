const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

module.exports = async (req , res , next) => {

    // Fill in the code

    // Edit Employee
    let id = req.params.id;

    Employee.findById(id, (err, employee) => {
        if(err)
            console.log("Can't find employee: %s ", err);
        if(!employee)
            return res.render('404');
        
        res.render('editEmployeeView', {
            title: "Edit an Employee", 
            data: {
                id: employee._id,
                firstName: employee.firstName,
                lastName: employee.lastName
            }
        });
    });
};

