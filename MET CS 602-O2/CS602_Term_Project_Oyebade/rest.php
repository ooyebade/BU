<?php 
require_once('database.php');

$format = filter_input(INPUT_GET, 'format');

if (isset($format)) {
    if ($format == 'xml')
        echo header("Content-type: text/xml");
    else if ($format == 'json')
        echo header("Content-type: application/json");
    else
        exit;
} else {
    $format = 'xml';
    echo header("Content-type: text/xml");
}

    // Get all products
    $query = 'SELECT * FROM products
                        ORDER BY id';
    $statement = $db->prepare($query);
    $statement->execute();
    $product = $statement->fetchAll(PDO::FETCH_ASSOC);
    $statement->closeCursor();

$action = filter_input(INPUT_GET, 'action');

if ($action == 'product') {
    if ($format == 'json') {
        echo json_encode($product, JSON_PRETTY_PRINT);
    }
    else {
        $doc = new DOMDocument('1.0');
        $doc->preserveWhiteSpace = false;
        $doc->formatOutput = true;
        $root = $doc->createElement('product');
        $root = $doc->appendChild($root);

        foreach ($product as $prod) {
            $productNode = $doc->createElement('prod');
            $productNode = $root->appendChild($productNode);
            
            foreach($prod as $key => $value) {
                $i = $doc->createElement($key, $value);
                $productNode->appendChild($i);
            }
        }

        echo $doc->saveXML() . "\n";
    }
}

elseif ($action == 'product_options') {
    if (isset($_GET['option'])) {
        $prod_id = filter_var($_GET['option'], FILTER_SANITIZE_STRING);

        // getting the products categories
        $queryProdOption = 'SELECT * FROM products_options
                            WHERE product_id = :prod_id
                            ORDER BY id';
        $statement3 = $db->prepare($queryProdOption);
        $statement3->bindValue(':prod_id', $prod_id);
        $statement3->execute();
        $option = $statement3->fetchAll(PDO::FETCH_ASSOC);
        $statement3->closeCursor();
    }

    if ($format == 'json') {
        echo json_encode($option, JSON_PRETTY_PRINT); 
    }
    else {
        $doc = new DOMDocument('1.0');
        $doc->preserveWhiteSpace = false;
        $doc->formatOutput = true;
        $root = $doc->createElement('option');
        $root = $doc->appendChild($root);

        foreach ($option as $opt) {
            $optionNode = $doc->createElement('opt');
            $optionNode = $root->appendChild($optionNode);
            
            foreach($opt as $key => $value) {
                $i = $doc->createElement($key, $value);
                $optionNode->appendChild($i);
            }
        }
        echo $doc->saveXML() . "\n";
    }
}
?>