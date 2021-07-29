DROP FUNCTION IF EXISTS get_risk_factor_for_client;
create
    definer = root@localhost function get_risk_factor_for_client(client_id int) returns int reads sql data
BEGIN
    DECLARE risk_factor DECIMAL(9, 2) DEFAULT 0;
    DECLARE invoices_total DECIMAL(9, 2);
    DECLARE invoices_count INT;

    SELECT COUNT(*), SUM(invoice_total)
    INTO invoices_count, invoices_total
    FROM invoices i
    WHERE i.client_id = client_id;
    SET risk_factor = invoices_total / invoices_count * 5;

    RETURN IFNULL(risk_factor, 0);
end;
