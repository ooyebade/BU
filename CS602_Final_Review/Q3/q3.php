<?php
    $chars=array("a", "b", "i", "c", "e", "f", 0, "z", 2);
       
    $intvalues = array();
    $consonant = array();
    $vowels = array();
    $numbers = array();
    
    foreach ($chars as $arrayvalue) {
            
        // is_int($arrayvalue) will return true if input character is number
        if(is_int($arrayvalue)==true){
            array_push($intvalues,$arrayvalue);
        }
        elseif(is_string($arrayvalue)==true){
            array_push($numbers, $arrayvalue);
        }
    }

    foreach($numbers as $num) {
        if ($num && ctype_alpha($num)) {

            // this will return 1 if input character matched with these small characters
            $l = $num == 'a' || $num == 'e' || $num == 'i' || $num == 'o' || $num == 'u';
                
            // this will return 1 if input character matched with these capital characters
            $u = $num == 'A' || $num == 'E' || $num == 'I' || $num == 'O' || $num == 'U';
                
            if ($l || $u){
                array_push($vowels,$num);
            }    
            else
                array_push($consonant, $num);
            } 
    }

    $number = implode(" ", $intvalues);
    echo "Numbers:".$number;
    echo "<br>";
    $consonents=implode(" ",$consonant);
    echo "Consonents:".$consonents;
    echo "<br>";
    $vowel=implode(" ",$vowels);
    echo "Vowels:".$vowel;
    echo "<br>";
?>