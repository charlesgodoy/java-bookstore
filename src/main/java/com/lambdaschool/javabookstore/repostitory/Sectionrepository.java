package com.lambdaschool.javabookstore.repostitory;

import com.lambdaschool.javabookstore.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Sectionrepository extends JpaRepository<Section, Long> {
}
