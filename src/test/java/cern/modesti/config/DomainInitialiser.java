package cern.modesti.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cern.modesti.repository.request.domain.Domain;
import cern.modesti.repository.request.domain.DomainRepository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteStreams;

/**
 * This class will delete and re-add all available domains from the domain
 * repository.
 * 
 * @author Justin Lewis Salmon
 *
 */
@Service
public class DomainInitialiser {
  private static final Logger LOG = LoggerFactory.getLogger(DomainInitialiser.class);

  private static final String PATH = "data/domains.json";

  @Autowired
  public DomainInitialiser(DomainRepository domainRepository) throws IOException {
    LOG.info("Initialising domains and datasources");
    ObjectMapper mapper = new ObjectMapper();

    domainRepository.deleteAll();

    byte[] bytes = ByteStreams.toByteArray(Thread.currentThread().getContextClassLoader().getResourceAsStream(PATH));
    List<Domain> domains = mapper.readValue(new String(bytes, StandardCharsets.UTF_8), new TypeReference<List<Domain>>() {});

    domainRepository.insert(domains);
  }

}