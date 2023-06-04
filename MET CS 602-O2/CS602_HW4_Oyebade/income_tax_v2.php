<?php

define('TAX_RATES',
  array(
    'Single' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,9700,39475,84200,160725,204100,510300),
      'MinTax' => array(0, 970,4543,14382,32748,46628,153798)
      ),
    'Married_Jointly' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,19400,78950,168400,321450,408200,612350),
      'MinTax' => array(0, 1940,9086,28765,65497,93257,164709)
      ),
    'Married_Separately' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,9700,39475,84200,160725,204100,306175),
      'MinTax' => array(0, 970,4543,14382.50,32748.50,46628.50,82354.75)
      ),
    'Head_Household' => array(
      'Rates' => array(10,12,22,24,32,35,37),
      'Ranges' => array(0,13850,52850,84200,160700,204100,510300),
      'MinTax' => array(0, 1385,6065,12962,31322,45210,152380)
      )
    )
);

// Fill in the code for the following function

function incomeTax($taxableIncome, $status) {
  $incTax = 0.0;

  $ranges = TAX_RATES[$status]['Ranges'];
  $rates = TAX_RATES[$status]['Rates'];
  $minTax = TAX_RATES[$status]['MinTax'];

  // determine the maximum array index
  $maxArray = max(array_keys($ranges));

  // loop over each rate for the given filing status
  foreach ($ranges as $key => $range) {

    if ($taxableIncome > $ranges[$maxArray]) {
      // convert the rates to decimals
      $ratesDec = $rates[$maxArray] / 100;
      // determine the income tax
      $incTax = (($taxableIncome - $ranges[$maxArray]) * $ratesDec) + $minTax[$maxArray];
      break;
    }
    elseif (($taxableIncome <= $range) && ($taxableIncome> $ranges[$key - 1 ])) {
      $ratesDec = $rates[$key - 1] / 100; // convert to decimal
      // determine the income tax
      $incTax = (($taxableIncome - $ranges[$key]) * $ratesDec) + $minTax[$key];
      break;
    }
  }
    
  return $incTax;
}

?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>HW4 Part2 - Elizabeth Oyebade</title>

  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

  <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
  </head>

  <body>

  <div class="container">

    <h3>Income Tax Calculator</h3>

    <form class="form-horizontal" method="POST" action="<?php htmlspecialchars($_SERVER["PHP_SELF"]); ?>">

      <div class="form-group">
        <label class="control-label col-sm-2">Enter Net Income:</label>
        <div class="col-sm-10">
          <input type="number"  step="any" name="netIncome" placeholder="Taxable  Income" required autofocus>
        </div>
      </div>
      <div class="form-group"> 
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" name="submitButton" class="btn btn-primary">Submit</button>
        </div>
      </div>

    </form>

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
          <div class="col-sm-6"><?php echo "$" .number_format(incomeTax($netIncome, 'Single'), 2); ?></div>
        </div>
      </li>
      <li class="list-group-item">
        <div class="row">
          <div class="col-sm-6">Married Filing Jointly</div>
          <div class="col-sm-6"><?php echo "$" .number_format(incomeTax($netIncome, 'Married_Jointly'), 2); ?></div>
        </div>
      </li>
      <li class="list-group-item">
        <div class="row">
          <div class="col-sm-6">Maried Filing Separately</div>
          <div class="col-sm-6"><?php echo "$" .number_format(incomeTax($netIncome, 'Married_Separately'), 2); ?></div>
        </div>
      </li>
      <li class="list-group-item">
        <div class="row">
          <div class="col-sm-6">Head Of Household</div>
          <div class="col-sm-6"><?php echo "$" .number_format(incomeTax($netIncome, 'Head_Household'), 2); ?></div>
        </div>
      </li>      
      </ul>	
    <!-- closes php tag -->
    <?php }; ?>

    <h3>2019 Tax Tables</h3>

    <?php

      // Fill in the code for Tax Tables display

      // echo "Tax Tables...";

      foreach (TAX_RATES as $key => $taxArray) {
        // display the filing header
        echo "<strong>" .$key ."</strong>";

        // create the tax table
        echo '<table class="table table-stripped">

          <thead class="table-success">
            <tr>
              <th scope="col">Taxable Income</th>
              <th scope="col">Tax Rate</th>
            </tr>
          </thead>

          <tbody>
            <tr>
              <td scope="row">';
                echo "$" .number_format(TAX_RATES[$key]['Ranges'][0]);
                echo " - $" .number_format(TAX_RATES[$key]['Ranges'][1]);
              echo '</td>
              <td>';
                echo TAX_RATES[$key]['Rates'][0] ."%";
              echo '</td>
            </tr>';

            // count the number of array elements 
						$loopCnt = count(TAX_RATES[$key]['Ranges']);		
						// get the highest index position in the array
						$maxTaxIndex = max(array_keys(TAX_RATES[$key]['Rates']));

						// loop to print the remaining rows, except the last row			
						for($i=1; $i < ($loopCnt - 1); $i++) {
								
							echo '<tr>
								<td scope="row">';								
									echo "$" .number_format((TAX_RATES[$key]['Ranges'][$i])+1);
									echo " - $" .number_format(TAX_RATES[$key]['Ranges'][$i + 1]);
								echo  '</td>
								<td>';
									echo "$" .number_format(TAX_RATES[$key]['MinTax'][$i], 2) ." plus ";
									echo TAX_RATES[$key]['Rates'][$i] ."% of the amount over ";
									echo "$" .number_format(TAX_RATES[$key]['Ranges'][$i]);
								echo  '</td>
							</tr>';
						}

						// print the last array element row that was left out of the for loop
						echo '<tr>
							<td scope="row">';		
								// print last row 						
								echo "$" .number_format((TAX_RATES[$key]['Ranges'][$maxTaxIndex]) + 1);
									echo " or more"; 
								echo '</td>
							<td>';
							  echo "$" .number_format(TAX_RATES[$key]['MinTax'][$maxTaxIndex], 2) ." plus ";
							  echo TAX_RATES[$key]['Rates'][$maxTaxIndex] ."% of the amount over ";
							  echo "$" .number_format(TAX_RATES[$key]['Ranges'][$maxTaxIndex]);		
							echo '</td>
            </tr>
          </tbody>
        </table>';
      }     
    ?>
  </div>
</body>
</html>