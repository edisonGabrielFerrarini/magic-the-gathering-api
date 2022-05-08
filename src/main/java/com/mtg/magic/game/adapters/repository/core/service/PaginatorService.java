package com.mtg.magic.game.adapters.repository.core.service;

import com.mtg.magic.game.core.domain.type.OrdemType;
import org.springframework.data.domain.Pageable;

public interface PaginatorService {

    Pageable gerarPaginacao(Integer pageNo, Integer pageSize, String sortBy, OrdemType ordemType);

}
