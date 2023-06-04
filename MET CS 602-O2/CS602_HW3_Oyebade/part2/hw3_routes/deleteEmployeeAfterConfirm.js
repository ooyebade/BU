const employeeDB = require('../employeeDB.js');
const Employee = employeeDB.getModel();

module.exports =  async (req , res , next) => {
    
  // Fill in the code
    
  // Delete Employee after confirmation
  let id = req.params.id;
    
  Employee.findById(id, (err, employee) => {
    if(err)
      console.log("Error Selecting : %s ", err);
    if(!employee)
      return res.render('404');

    employee.remove((err) => {
      if(err)
        console.log("Error deleting : %s ", err);
        res.redirect('/employees');
    });
  });
};

  