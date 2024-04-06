package com.nouhaTeamleaf.nouhaTeamleaf.data.fixtures;

import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Classe;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.ClasseModule;
import com.nouhaTeamleaf.nouhaTeamleaf.data.entitties.Module;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ClasseModuleRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ClasseRepository;
import com.nouhaTeamleaf.nouhaTeamleaf.data.repositories.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(9)
@RequiredArgsConstructor
//@Component
public class ClasseModuleFixtures implements CommandLineRunner {
    private final ClasseRepository classeRepository;
    private final ModuleRepository moduleRepository;
    private final ClasseModuleRepository classeModuleRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Classe> classeList = classeRepository.findAll();
        List<Module> moduleList = moduleRepository.findAll();
        for (long i = 0; i < classeList.size(); i++) {
            ClasseModule classeModule = new ClasseModule();

            Classe classe = classeList.get((int) i);


            classeModule.setClasse(classe);
            for (long j = 0; j <=moduleList.size() ; j++) {
                Module module = moduleRepository.findById(j).orElse(null);
                classeModule.setModule(module);

            }
            classeModule.setIsActive(true);

            classeModuleRepository.save(classeModule);

        }

    }
}
