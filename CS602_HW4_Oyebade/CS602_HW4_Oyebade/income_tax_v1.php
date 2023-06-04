<?php

    // Fill in the code for the following four functions
    // calculating taxes
    // income tax brackets for single filing 
    function incomeTaxSingle($taxableIncome) {
        $incTax = 0.0;

        if($taxableIncome >= 0 && $taxableIncome <= 9700) {
            $incTax = (10 * $taxableIncome) / 100;
        }
        elseif($taxableIncome >= 9700 && $taxableIncome <= 39475) {
            $incTax = 970 + ((12 * ($taxableIncome - 9700)) / 100);
        }
        elseif($taxableIncome >= 39475 && $taxableIncome <= 84200) {
            $incTax = 4543 + ((22 * ($taxableIncome - 39475)) / 100);
        }
        elseif($taxableIncome >=84200 && $taxableIncome <= 160725) {
            $incTax = 14382 + ((24 * ($taxableIncome - 84200)) / 100);
        }
        elseif($taxableIncome >=160725 && $taxableIncome <= 204100) {
            $incTax = 32748 + ((32 * ($taxableIncome - 160725)) / 100);
        }
        elseif($taxableIncome >=204100 && $taxableIncome <= 510300) {
            $incTax = 46628 + ((35 * ($taxableIncome - 204100)) / 100);
        }
        else {
            $incTax = 153798 + ((37 * ($taxableIncome - 510300)) / 100);
        }
    
        return $incTax;
    }

    // calculating taxes
    // income tax brackets for married couples filing jointly 
    function incomeTaxMarriedJointly($taxableIncome) {
        $incTax = 0.0;

        if($taxableIncome >= 0 && $taxableIncome <= 19400) {
            $incTax = (10 * $taxableIncome) / 100;
        }   
        elseif($taxableIncome >= 19400 && $taxableIncome <= 78950) {
            $incTax = 1940 + ((12 * ($taxableIncome - 19400)) / 100);
        }
        elseif($taxableIncome >= 78950 && $taxableIncome <= 168400) {
            $incTax = 9086 + ((22 * ($taxableIncome - 78950)) / 100);
        }
        elseif($taxableIncome >=168400 && $taxableIncome <= 321450) {
            $incTax = 28765 + ((24 * ($taxableIncome - 168400)) / 100);
        }
        elseif($taxableIncome >=321450 && $taxableIncome <= 408200) {
            $incTax = 65497.50 + ((32 * ($taxableIncome - 321450)) / 100);
        }
        elseif($taxableIncome >=408200 && $taxableIncome <= 612350) {
            $incTax = 93257 + ((35 * ($taxableIncome - 408200)) / 100);
        }
        else {
            $incTax = 164709 + ((37 * ($taxableIncome - 612350)) / 100);
        }
        return $incTax;
    }

    // calculating taxes
    // income tax brackets for married couples filing separately
    function incomeTaxMarriedSeparately($taxableIncome) {
        $incTax = 0.0;

        if($taxableIncome >= 0 && $taxableIncome <= 9700) {
            $incTax = (10 * $taxableIncome) / 100;
        }
        elseif($taxableIncome >= 9700 && $taxableIncome <= 39475) {
            $incTax = 970 + ((12 * ($taxableIncome - 9700)) / 100);
        }
        elseif($taxableIncome >= 39475 && $taxableIncome <= 84200) {
            $incTax = 4543 + ((22 * ($taxableIncome - 39475)) / 100);
        }
        elseif($taxableIncome >=84200 && $taxableIncome <= 160725) {
            $incTax = 14382.50 + ((24 * ($taxableIncome - 84200)) / 100);
        }
        elseif($taxableIncome >=160725 && $taxableIncome <= 204100) {
            $incTax = 32748.50 + ((32 * ($taxableIncome - 160725)) / 100);
        }
        elseif($taxableIncome >=204100 && $taxableIncome <= 306175) {
            $incTax = 46628.50 + ((35 * ($taxableIncome - 204100)) / 100);
        }   
        else {
            $incTax = 82354.75 + ((37 * ($taxableIncome - 306175)) / 100);
        }
    
        return $incTax;
    }

    // calculating taxes
    // income tax brackets for the head of household 
    function incomeTaxHeadOfHousehold($taxableIncome) {
        $incTax = 0.0;

        if($taxableIncome >= 0 && $taxableIncome <= 13850) {
            $incTax = (10 * $taxableIncome) / 100;
        }
        elseif($taxableIncome >= 13850 && $taxableIncome <= 52850) {
            $incTax = 1385 + ((12 * ($taxableIncome - 13850)) / 100);
        }
        elseif($taxableIncome >= 52850 && $taxableIncome <= 84200) {
            $incTax = 6065 + ((22 * ($taxableIncome - 52850)) / 100);
        }
        elseif($taxableIncome >=84200 && $taxableIncome <= 160700) {
            $incTax = 12962 + ((24 * ($taxableIncome - 84200)) / 100);
        }
        elseif($taxableIncome >=160700 && $taxableIncome <= 204100) {
            $incTax = 31322 + ((32 * ($taxableIncome - 160700)) / 100);
        }   
        elseif($taxableIncome >=204100 && $taxableIncome <= 510300) {
            $incTax = 45210 + ((35 * ($taxableIncome - 204100)) / 100);
        }
        else {
            $incTax = 152380 + ((37 * ($taxableIncome - 510300)) / 100);
        }

        return $incTax;
    }

?>

<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <title>HW4 Part1 - Elizabeth Oyebade</title>

  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </head>
    <body>

    <div class="container">

    <h3>Income Tax Calculator</h3>

    <form method="POST" action="<?php htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

        
        <div class="form-group">
            <label class="control-label col-sm-2">Your Net Income:</label>
            <div class="col-sm-10">
                <input type="number" name="netIncome" placeholder="Taxable  Income" required autofocus>
            </div>
            <br>
            <br>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" name="submitButton" class="btn btn-primary">Submit</button>
            </div>
        </div>

    </form>

    <br>
    <br>
    <?php

        // Fill in the rest of the PHP code for form submission results
        if(isset($_POST['submitButton'])) {
            $netIncome = $_POST['netIncome'];
        }
    
        // hide output of tax table by default
        $displayResult = false;
    
        // check user input
        $isValid = null;
    
        // if the form was submitted
        if ($_SERVER['REQUEST_METHOD'] === 'POST') {
            if(filter_var($netIncome, FILTER_VALIDATE_FLOAT)) {
                $isValid == true;
                // display result if a number is entered
                $displayResult = true;
            }
            else {
                $isValid = false;
            }
    
            // calculate taxes
            $incomeSingle = incomeTaxSingle($netIncome);
            $incomeMarriedJointly = incomeTaxMarriedJointly($netIncome, 2);
            $incomeMarriedSeparately = incomeTaxMarriedSeparately($netIncome, 2);
            $headofhousehold = incomeTaxHeadOfHousehold($netIncome, 2);
    
            // echo "Results...";
        }

        if($displayResult) {
            echo "With a net taxable income of $" .number_format($netIncome, 2);
        ?>

        <br><br>
		<ul class="list-group">
		<li class="list-group-item active">
			<div class="row">
				<div class="col-sm-6">Status</div>
				<div class="col-sm-6">Tax</div>
			</div>
		</li>
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-6">Single</div>
				<div class="col-sm-6"><?php echo "$" .number_format($incomeSingle, 2); ?></div>
			</div>
		</li>
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-6">Married Filing Jointly</div>
				<div class="col-sm-6"><?php echo "$" .number_format($incomeMarriedJointly, 2); ?></div>
			</div>
		</li>
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-6">Maried Filing Separately</div>
				<div class="col-sm-6"><?php echo "$" .number_format($incomeMarriedSeparately, 2); ?></div>
			</div>
		</li>
		<li class="list-group-item">
			<div class="row">
				<div class="col-sm-6">Head Of Household</div>
				<div class="col-sm-6"><?php echo "$" .number_format($headofhousehold, 2); ?></div>
			</div>
		</li>      
		</ul>	

	<!-- closes php tag -->
	<?php }; ?>
    </div>

</body>
</html>