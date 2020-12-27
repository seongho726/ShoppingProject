-- activist insert[재능 기부자 저장]
insert into activist values('giver1', '나의사', 'gp1', 'dermatology');
insert into activist values('giver2', '오드리', 'gp2', 'culture');
insert into activist values('giver3', '키다리', 'gp3', 'mentor');

-- recipient insert[재능 수혜자 저장]
insert into recipient values('receivePeople1', '나아토피', 'rp1', '아토피 치료');
insert into recipient values('receivePeople2', '나문화', 'rp2', '감성 치료');
insert into recipient values('receivePeople3', '나멘토', 'rp3', '심리 상담');

-- probono insert[재능기부 정보 저장]
insert into probono values('schweitzer', '슈바이처 프로젝트', '의사, 한의사, 수의사등의 의료 활동 및 후원 등 의료, 보건, 건강과 관련된 분야');
insert into probono values('audreyHepbun', '오드리햅번 프로젝트', '예술가, 문화관련 프로그램 제공, 전시ㆍ관람 등 기회제공, 미용,환경 캠페인 등 문화ㆍ예술관련 분야');
insert into probono values('daddyLongLegs', '키다리아저씨 프로젝트', '결연, 상담, 멘토, 독서ㆍ학습지도 및 교육기회 제공, 장학지원, 심리상담 등 멘토링, 상담, 교육, 결연분야');

-- probono_project insert[재능 기부 프로젝트 저장]
insert into probono_project values(probono_project_id_seq.nextval, '슈바이처 프로젝트', 'schweitzer', 'giver1', 'receivePeople1', '아토피 무상 치료');
insert into probono_project values(probono_project_id_seq.nextval, '오드리햅번 프로젝트', 'audreyHepbun', 'giver2', 'receivePeople2', '무료컷팅');
insert into probono_project values(probono_project_id_seq.nextval, '키다리아저씨 프로젝트', 'schweitzer', 'giver3', 'receivePeople3', '장학금지원');

commit;
