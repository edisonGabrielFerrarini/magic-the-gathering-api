package com.mtg.magic.game.adapters.repository.core.service.impl;

import com.mtg.magic.game.adapters.repository.core.service.PaginatorService;
import com.mtg.magic.game.core.domain.type.OrdemType;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.mtg.magic.game.core.domain.type.OrdemType.ASC;

@Service
public class PaginadorServiceImpl implements PaginatorService {

    public Pageable gerarPaginacao(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType){
        Pageable pageable;
        if (ASC == ordemType) {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        }
        return pageable;
    }

}
