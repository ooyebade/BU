var data = [
    {
        projectName: "Project1", projectId: 'p1',
        employees: [
            {fullName: "John Doe", employeeId: 'e1'},
            {fullName: "Jane Smith", employeeId: 'e2'}
        ]
    },
    {
        projectName: "Project2", projectId: 'p2',
        employees: [
            {fullName: "John Doe", employeeId: 'e1'},
            {fullName: "Mary Jones", employeeId: 'e3'},
            {fullName: "Bill Evans", employeeId: 'e4'}
        ]
    }
];

// functions
module.exports.lookupByProjectId = function (id) {
    const result = data.find(item => item.projectId === id);
    return result ? result : undefined;
};

module.exports.lookupByEmployeeId = function(id) {
    const filterData = [];
    /*
    for (let item of data) {
        // Conditional check to see if both city and state values of the current object is equal to the passed args
        console.log(this.employees.employeeId);
        if (item.employees.employeeId === id) {
            // Add items to the filterData array
            console.log('hello');
        }
    }
    return { filterData };
    */
    const res = data
        .filter(item => item.employees.employeeId === id)
        .map(item => {
            return { projectName: item.projectName };
        });
};