package com.online.toram.service;

import com.online.toram.domain.Crystal;
import com.online.toram.repository.CrystalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CrystalService {

    private final CrystalRepository crystalRepository;

    @Transactional
    public void save(Crystal crystal) {
        crystalRepository.save(crystal);
    }

    @Transactional
    public void updateName(Long id, String name) {
        Crystal crystal = crystalRepository.findOne(id);
        crystalRepository.updateName(crystal, name);
    }

    
}
