package edu.axboot.domain.bom;

import com.chequer.axboot.core.parameter.RequestParams;
import com.querydsl.core.BooleanBuilder;
import edu.axboot.domain.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EducationBomService extends BaseService<EducationBom, Long> {
    private static final Logger logger = LoggerFactory.getLogger(EducationBomService.class);

    private EducationBomRepository educationBomGridRepository;

  //  @Inject
    private EducationBomMapper educationBomMapper;

    @Inject
    public EducationBomService(EducationBomRepository educationBomGridRepository) {
        super(educationBomGridRepository);
        this.educationBomGridRepository = this.educationBomGridRepository;
    }

    //jpa
    public List<EducationBom> gets(RequestParams<EducationBom> requestParams) {
        List<EducationBom> list2 = this.getFilter(findAll(), requestParams.getString("companyNm", ""), 1);
        List<EducationBom> list3 = this.getFilter(list2, requestParams.getString("ceo", ""), 2);
        List<EducationBom> list4 = this.getFilter(list3, requestParams.getString("bizno", ""), 3);
        List<EducationBom> list5 = this.getFilter(list4, requestParams.getString("useYn", ""), 4);
        return list5;
    }

    private List<EducationBom> getFilter(List<EducationBom> sources, String filter, int typ) {
        List<EducationBom> targets = new ArrayList<EducationBom>();
        for (EducationBom entity : sources) {
            if ("".equals(filter)) {
                targets.add(entity);
            } else {
                if (typ == 1) {
                    if (entity.getCompanyNm().contains(filter)) {
                        targets.add(entity);
                    }
                } else if (typ == 2) {
                    if (entity.getCeo().contains(filter)) {
                        targets.add(entity);
                    }
                } else if (typ == 3) {
                    if (entity.getBizno().equals(filter)) {
                        targets.add(entity);
                    }
                } else if (typ == 4) {
                    if (entity.getUseYn().equals(filter)) {
                        targets.add(entity);
                    }
                }
            }
        }
        return targets;
    }

    
    // QueryDsl
    public List<EducationBom> gets(String companyNm, String ceo, String bizno, String useYn) {

        logger.info("회사명: " + companyNm);
        logger.info("대표자: " + ceo);
        logger.info("사업자번호: " + bizno);
        logger.info("사용여부: " + useYn);

        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(companyNm)) {
            builder.and(qEducationBom.companyNm.like("%" + companyNm + "%"));
        }

        if (isNotEmpty(ceo)) {
            builder.and(qEducationBom.ceo.like(("%" + ceo + "%")));
        }

        if (isNotEmpty(bizno)) {
            builder.and(qEducationBom.bizno.like("%" + bizno + "%"));
        }
        if (isNotEmpty(useYn)) {
            builder.and(qEducationBom.useYn.eq(useYn));
        }

        List<EducationBom> list = select()
                .from(qEducationBom)
                .where(builder)
                .orderBy(qEducationBom.companyNm.asc())
                .fetch();

        return list;

    }

    public EducationBom getByOne(Long id) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(qEducationBom.id.eq(id));


        EducationBom entity = select()
                .from(qEducationBom)
                .where(builder)
                .fetchOne();

        return entity;

    }

    @Transactional
    public void persist(EducationBom request) {
        if (request.getId() == null || request.getId() == 0) {
            save(request);
        } else {
            update(qEducationBom)
                    .set(qEducationBom.companyNm, request.getCompanyNm())
                    .set(qEducationBom.ceo, request.getCeo())
                    .set(qEducationBom.bizno, request.getBizno())
                    .set(qEducationBom.useYn, request.getUseYn())
                    .set(qEducationBom.tel, request.getTel())
                    .set(qEducationBom.zip, request.getZip())
                    .set(qEducationBom.address, request.getAddress())
                    .set(qEducationBom.addressDetail, request.getAddressDetail())
                    .set(qEducationBom.email, request.getEmail())
                    .set(qEducationBom.remark, request.getRemark())
                    .where(qEducationBom.id.eq(request.getId()))
                    .execute();
        }

    }

    @Transactional
    public void remove(Long id) {
        delete(qEducationBom).where(qEducationBom.id.eq(id)).execute();
    }

    //mybatis

    public List<EducationBom> select(String companyNm, String ceo, String bizno, String useYn) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("companyNm", companyNm);
        params.put("ceo", ceo);
        params.put("bizno", bizno);
        params.put("useYn", useYn);

        List<EducationBom> list = educationBomMapper.select(params);
        return list;
    }

    public EducationBom selectOne(Long id) {
        return educationBomMapper.selectOne(id);
    }

    public void enroll(EducationBom request) {
        if(request.getId() == null || request.getId() == 0) {
        educationBomMapper.insert(request);
    } else {
            educationBomMapper.insert(request);
    }
}

    public void del(Long id) {
        educationBomMapper.delete(id);
    }
}



