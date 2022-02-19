delimiter//
DROP PROCEDURE IF EXISTS ex_5_b//
CREATE PROCEDURE ex_5_b(IN p_total FLOAT, OUT p_nume VARCHAR(30))
BEGIN
SELECT nume INTO p_nume 
FROM Client 
WHERE id_c IN (SELECT id_c  FROM Factura WHERE EXTRACT(YEAR FROM data)=p_total 
AND total >=ALL (SELECT total FROM Factura WHERE EXTRACT(YEAR FROM data)=p_total ));
END// 

DROP PROCEDURE IF EXISTS ex_6_b//
CREATE PROCEDURE ex_6_b(IN p_an FLOAT, OUT p_rez DOUBLE)
BEGIN
SELECT AVG(total) INTO p_rez
FROM Factura
WHERE EXTRACT(YEAR FROM data)=p_an;
END// 