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

module.exports.lookupByEmployeeId = function (id) {

    let items = data;

    const result = items 
    .filter(item => item.employees.employeeId === id)
    .map(item => {
        return { projectName: item.projectName };
        })
    // return {id, employees: result};
};