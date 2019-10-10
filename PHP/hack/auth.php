<?php

    $id = $_GET["id"];
    $uname = $_GET["uname"];
    $pwd = $_GET["pwd"];
    $server = "localhost";
    $suname="hack";
    $spwd="hackathon";
    $db = "hack";


    $connection = new mysqli($server, $suname, $spwd, $db);

    function authenticate(&$tb, &$connection, &$uname, &$pwd) {
        $query = "SELECT * FROM ".$tb;
        $result = $connection->query($query);
        $col1 = "uname";
        $col2 = "pwd";
        $obj = new stdClass();
        $obj->status = -100;
        $obj->id = 0;
        $flag = FALSE;
        if ($result->num_rows > 0){
            while($row = $result->fetch_assoc()) {
                if($row[$col1] === $uname){
                    $flag = TRUE;
                    if($row[$col2] === md5($pwd)){
                        $obj->status = 0;
                        $obj->err = "";
                       echo json_encode($obj);
                    }else{
                        $obj->status = -1;
                        $obj->err = "Incorrect password.";
                        echo json_encode($obj);
                    }
                    break;
                }
            }
            
        }
        
        if (!$flag){
            $q = "INSERT INTO ".$tb." VALUES('".$uname."','".md5($pwd)."')";
            if ($connection->query($q) === TRUE) {
                $obj->status = 0;
                $obj->id = 1;
                $obj->err = "";
                echo json_encode($obj);
            } else {
                $obj->status = -1;
                $obj->id = 1;
                $obj->err = "Some error occurred.";
                echo json_encode($obj);
            }
        }
        
    }
    if($id === "doc"){
        $tb = "doc_auth";
        authenticate($tb, $connection, $uname, $pwd);
        
    }else if ($id === "user"){
        $tb = "user_auth";
        authenticate($tb, $connection, $uname, $pwd);
    }

?>