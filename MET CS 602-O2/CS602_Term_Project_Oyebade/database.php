<?php
    $dsn = 'mysql:host=localhost;dbname=cs602_term_projectdb';
    $username = 'cs602_term';
    $password = 'cs602_secret';

    try {
        $db = new PDO($dsn, $username, $password);
    } catch (PDOException $e) {
        exit('Failed to connect to database!');
    }
?>