<?php
    include_once('header.php');
?>

 <div id="mainimage">
    <h1>Coronadaten</h1>
</div>
<div id="maincontent">
<div style="width:100%; text-align:center;">
<h2>Zahlen nach Bundesland</h2> 
</div>

        <table style="width:50%">
        <th>Bundesland</th>
        <th>Anzahl</th>
        <?php 
            $mysqli = new mysqli ('localhost', 'root', '', 'corona');

            if ($mysqli->connect_error) {
                echo "Verbindung fehlgeschlagen".$mysqli->connect_error; 
                exit();
            }

            //echo "Verbindung hergestellt";

            //$sql = "SELECT * FROM person;";
            $sql ="SELECT province_name, count(person_id) as anzahl FROM person
            JOIN province
            ON person.province_id = province.province_id
            WHERE status = 'A'
            GROUP BY province_name;";

            //echo "<br/>".$sql;

            $result =$mysqli->query($sql);
            
            while ($row=$result->fetch_assoc()){
                echo "<tr><td>".$row['province_name']."</td><td>".$row['anzahl']."</td></tr>";
            }

            //echo '<br/>Anzahl der Datensätze: '.$result->num_rows;
            
            //$datensaetze = $result->fetch_assoc(); //ARRAY 
            //print_r($datensaetze);

            //$datensaetze2 = $result->fetch_assoc(); //ARRAY 
            //print_r($datensaetze2);

            /*while($row=$result->fetch_assoc()) {
                echo $row['gender'].' '.$row['registration_date']. ' '.$row['province_id'].'<br/>';
            }*/

            $mysqli->close();
        ?>

</table>
        </div>
<?php
    include_once('footer.php');
?>