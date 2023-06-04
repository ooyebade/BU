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

    // Get all courses
    $query = 'SELECT * FROM sk_courses
                           ORDER BY courseID';
    $statement = $db->prepare($query);
    $statement->execute();
    $courses = $statement->fetchAll(PDO::FETCH_ASSOC);
    $statement->closeCursor();

$action = filter_input(INPUT_GET, 'action');

if ($action == 'courses') {
    if ($format == 'json') {
        echo json_encode($courses, JSON_PRETTY_PRINT); 
    }
    else {
        $doc = new DOMDocument('1.0');
        $doc->preserveWhiteSpace = false;
        $doc->formatOutput = true;
        $root = $doc->createElement('courses');
        $root = $doc->appendChild($root);

        foreach ($courses as $course) {
            $courseNode = $doc->createElement('course');
            $courseNode = $root->appendChild($courseNode);
            
            foreach($course as $key => $value) {
                $i = $doc->createElement($key, $value);
                $courseNode->appendChild($i);
            }
        }

        echo $doc->saveXML() . "\n";
    }
}

elseif ($action == 'students') {

    # Fill in the code for this part

    // check if there is a course param in the url
    if (isset($_GET['course'])) {                
        $course_id = filter_var($_GET['course'], FILTER_SANITIZE_STRING);

        // Get students for selected course
        $queryStudents = 'SELECT * FROM sk_students
                          WHERE courseID = :course_id
                          ORDER BY studentID';
        $statement3 = $db->prepare($queryStudents);
        $statement3->bindValue(':course_id', $course_id);
        $statement3->execute();
        $students = $statement3->fetchAll(PDO::FETCH_ASSOC);
        $statement3->closeCursor();
    }

    if ($format == 'json') {
        echo json_encode($students, JSON_PRETTY_PRINT); 
    }
    else {
        $doc = new DOMDocument('1.0');
        $doc->preserveWhiteSpace = false;
        $doc->formatOutput = true;
        $root = $doc->createElement('students');
        $root = $doc->appendChild($root);

        foreach ($students as $student) {
            $studentNode = $doc->createElement('student');
            $studentNode = $root->appendChild($studentNode);
            
            foreach($student as $key => $value) {
                $i = $doc->createElement($key, $value);
                $studentNode->appendChild($i);
            }
        }
        echo $doc->saveXML() . "\n";
    }
}
?>