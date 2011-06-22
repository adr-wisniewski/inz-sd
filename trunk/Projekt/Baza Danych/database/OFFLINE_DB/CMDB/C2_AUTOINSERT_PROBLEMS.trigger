CREATE OR REPLACE TRIGGER c2_autoinsert_problems
    AFTER INSERT ON problems
    REFERENCING NEW AS problem
    FOR EACH ROW
BEGIN
    INSERT INTO C2_ENTITIES (ENTITY_ID, VERSION)
        VALUES (C2_ENTITIES_SEQ.nextval, 0);
		
	INSERT INTO C2_ITEMS (ITEM_ID, LABEL)
        VALUES (C2_ENTITIES_SEQ.currval, 'PROBLEM #' || to_char(:problem.PROBLEM_ID));

    INSERT INTO C2_ITEMS_PROBLEM (ITEM_ID, PROBLEM_ID)
        VALUES (C2_ENTITIES_SEQ.currval, :problem.PROBLEM_ID);
END;
/