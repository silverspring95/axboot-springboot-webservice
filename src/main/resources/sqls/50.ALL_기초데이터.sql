-- 최초 실습용 그리드 추가 ########################################
-- 메뉴 그룹 - 교육 실습용
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (500, 'SYSTEM_MANAGER', '학생용 셈플', '{"ko":"학생용 셈플","en":"학생용 셈플"}',  null, 0, 99, null, sysdate(), 'system', sysdate(), 'system');

-- 실습용 그리드 추가
-- 프로그램 생성
INSERT INTO PROG_M (PROG_CD, PROG_NM, PROG_PH, TARGET, AUTH_CHECK, SCH_AH, SAV_AH )
VALUES ('education-bom-grid', '실습용 그리드', '/jsp/bom/education-bom-grid.jsp', '_self', 'Y', 'Y', 'Y');
-- 메뉴 생성
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (501, 'SYSTEM_MANAGER', '실습용 그리드', '{"ko":"실습용 그리드","en":"실습용 그리드"}',  500, 1, 1, 'education-bom-grid', sysdate(), 'system', sysdate(), 'system');
-- 메뉴 권한
INSERT INTO AUTH_GROUP_MAP_M (GRP_AUTH_CD , MENU_ID, SCH_AH, SAV_AH, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES ('S0001', '501',  'Y', 'Y', sysdate(), 'system', sysdate(), 'system');

INSERT INTO PROG_M (PROG_CD, PROG_NM, PROG_PH, TARGET, AUTH_CHECK, SCH_AH, SAV_AH )
VALUES ('education-bom-grid-form', '실습용 그리드 폼', '/jsp/bom/education-bom-grid-form.jsp', '_self', 'Y', 'Y', 'Y');
-- 메뉴 생성
INSERT INTO MENU_M (MENU_ID, MENU_GRP_CD, MENU_NM, MULTI_LANGUAGE, PARENT_ID, LEVEL, SORT, PROG_CD, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES (502, 'SYSTEM_MANAGER', '실습용 그리드 폼', '{"ko":"실습용 그리드 폼","en":"실습용 그리드 폼"}',  500, 1, 2, 'education-bom-grid-form', sysdate(), 'system', sysdate(), 'system');
-- 메뉴 권한
INSERT INTO AUTH_GROUP_MAP_M (GRP_AUTH_CD , MENU_ID, SCH_AH, SAV_AH, CREATED_AT, CREATED_BY, UPDATED_AT, UPDATED_BY )
VALUES ('S0001', '502',  'Y', 'Y', sysdate(), 'system', sysdate(), 'system');

