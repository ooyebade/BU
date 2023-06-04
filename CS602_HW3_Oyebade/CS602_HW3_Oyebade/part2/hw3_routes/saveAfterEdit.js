const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

module.exports = async (req , res , next) => {

    // Fill in the code

    // Save Employee After Editing
    var id = req.params.id;

    Employee.findById(id, (err, employee) => {
        if(err) console.log("Error Selecting : %s ", err);
        if(!employee) return res.render('404');

        employee.firstName = req.body.fname;
        employee.lastName = req.body.lname;

        employee.save((err) => {
            if(err)
                console.log("Error updating : %s ", err );
            res.redirect('/employees');
        });
    });
};
