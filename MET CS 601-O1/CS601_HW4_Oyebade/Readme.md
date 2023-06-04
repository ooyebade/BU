//* ----------------------------------
// * CS 601 Assignment
// * Form Validation and Submission
* ------------------------------------ */
/**
* 1. Create an HTML form with the following form controls:
*      a. text input field with a name and id value of: “firstName” (required)
*           i. When you submit the form: enter your first name here
*      b. text input field with a name and id value of: “lastName” (required)
*           i. When you submit the form: enter your last name here
*      c. text input field with a name and id of: “facilitator” (required)
*      d. a group of radio buttons with your choice of options
*      e. a group of check boxes with your choice of values
*      f. Style the page with CSS using an external style sheet.
*      g. The form action should point to http://bucs601.com/submit.php
*          using the POST method.
* 2. Use HTML and JavaScript to perform client-side validation based on the following specifications:
*      a. Validate both firstName and lastName to ensure:
*           i. a minimum length of two (2) characters
*           ii. that only alpha characters are used (A-Z and a-z)
*      b. Validate facilitator and constrain the possible valid values to be those of the active facilitators for * *          the course during this semester. For example, if we have facilitators with the following first
*          names: “Laura”, “Fazil”, and “Harsh”, you would ensure that only these values would pass validation
*           i. Laura OR Fazil OR Harsh
*      c. facilitator is a text input, don’t change this into a select or any other type of input.
*      d. The form should not be permitted to submit unless all fields pass validation.
*/