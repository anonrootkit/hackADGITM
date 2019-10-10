<?php
    $server = "localhost";
    $suname="hack";
    $spwd="hackathon";
    $db = "hack";

    $connection = new mysqli($server, $suname, $spwd, $db);
    
    $sql = "Select uname from doc_auth";

    $result = $connection->query($sql);
    
    $obj = new stdClass();
    $i = 0;
    $arr = [];
    if($result->num_rows > 0){
        while($row = $result->fetch_assoc()){
            $obj->arr[$i] = $row["uname"];
            $i++;
        }
        echo json_encode($obj);
    }
    
    

    
?>