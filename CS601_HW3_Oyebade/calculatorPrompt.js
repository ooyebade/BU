function greetUser() 
{
    var userName = prompt("Please enter your name: ");
    if (userName == null || userName == "")
    {
        alert("You didn't enter your name. Still, Welcome!!");
    } 
    else 
    {
        alert("Welcome " + userName + "!!");
    }
}

function calc()
{
    var num1 = askNum("first");
    var num2 = askNum("second");
    var sum = addSum(num1, num2);
    if (numValidate(sum))
    {
        alert("The sum of your two number is: " + sum);
        evalSum(sum);
    }
    else
    {
        alert("I don't understand this input. Please enter the proper number. Thank you!!");
    }
}

function askNum(numName) 
{
    return parseFloat(prompt("Please enter the " + numName + " number: "));
}

function addSum(num1, num2)
{
    return(num1 + num2);
}

function isFloat(num)
{
    return num === +num && num !== (num | 0);
}

function isInt(num)
{
    return num === +num && num === (num | 0);
}

function numValidate(sum)
{
    return isFloat(sum) || isInt(sum);
}

function evalSum(sum)
{
    if(sum > 10)
    {
        alert("That is a big number.")
    }
    else
    {
        alert("That is a small number.")
    }
}

function askCont() 
{
    var cont = window.confirm("Do you wanna add two numbers again?");
    if (cont)
    {
        alert("You've chosen to use the calculator again!!");
        return true;
    }
    else {
        alert("Thanks for visiting the program! Program will now exist....")
        return false;
    }
}