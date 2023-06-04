const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

module.exports = async (req , res , next) => {
    
  // Fill in the code

  // Delete Employee
  let id = req.params.id;

  Employee.findById(id, (err, employee) => {
    if(err)
      console.log("Error Selecting : %s ", err);
    if(!employee)
      return res.render('404');

    res.render('deleteEmployeeView', {
      title: "Delete Employee?", 
      data: {
        id: employee._id,
        firstName: employee.firstName,
        lastName: employee.lastName
      }
    });

  });
};

  