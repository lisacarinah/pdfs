<?php
    include_once('header.php');
?>

 <div id="mainimage">
    <h1>Coronadaten</h1>
</div>
<div id="maincontent">
<?php
                        $mydatabase = new mysqli ("localhost", "root", "", "corona");
                    
                        //check connection
                        if ($mydatabase->connect_errno) {
                            printf("Connection failed : %s\n", $mydatabase->connect_error);
                            exit();
                        }

                        $reg_date = $_POST["reg_date"];
                        $province = $_POST["province"];
                        $gender = $_POST["gender"];


                        $sql = "UPDATE person
                        SET status='I', inactive_date=now() 
                        WHERE registration_date='".$reg_date."' AND province_id='".$province."' AND gender='".$gender."' LIMIT 1;";
                        
                        //echo ($sql);
                    
                        if ($mydatabase->query($sql))
                        {
                            echo "<div>Eine Person wurde erfolgreich gesund gemeldet!</div>";
                        }
                       
                        //close connection 
                        $mydatabase->close();

                    ?>
                    
                    </table>
    
</div>

<?php
    include_once('footer.php');
?>