package com.kodlamaiodevs.project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodlamaiodevs.project.entities.LanguageTechnology;
import com.kodlamaiodevs.project.business.requests.CreateLanguageTechnologyRequest;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        /*
         *  ModelMapper id alanını da eşliyor, bu da sorun yaratıyor çünkü veritabanına yeni bir kayıt eklemek istediğinizde id alanının sıfırlanmış (otomatik artan) olması gerekiyor.

            ModelMapper Eşleme:

            ModelMapper kullanarak bir CreateLanguageTechnologyRequest nesnesini LanguageTechnology nesnesine dönüştürdüğünüzde, id alanını da eşliyor. (createlang da programminglanguageid var onunla eşliyor)
            Eğer CreateLanguageTechnologyRequest nesnesinde bir id alanı varsa, bu değer LanguageTechnology nesnesine atanıyor.
            Bu durumda, id alanı otomatik artan bir alan olduğu için veritabanına yeni bir kayıt eklerken hata alıyorduk yani aynı dile 1 den fazla teknoloji ekleyemiyorduk.

            Veritabanına Kaydetme:
            Veritabanına yeni bir kayıt eklemek istediğinizde, id alanının otomatik olarak veritabanı tarafından atanması için sıfırlanmış olması gerekiyor.
            languageTechnology.setId(0); ifadesi bu yüzden ekleme yaparken kullanılabilir ya da buralarda bir kontrol yapılabilir.
         */
        modelMapper.typeMap(CreateLanguageTechnologyRequest.class, LanguageTechnology.class).addMappings(mapper -> {
            mapper.skip(LanguageTechnology::setId);
        });
        return modelMapper;
    }
}
