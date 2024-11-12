package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.domain.Deployment;
import org.dimanu.deployservice.domain.DeploymentMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DeploymentRepositoryShould {

    private static final String VERSION = "1.0.0";
    private InMemoryDeploymentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryDeploymentRepository();
    }

    @Test
    void save_a_deployment() {
        Deployment deployment = DeploymentMother.withVersion(VERSION);

        repository.save(deployment);

        Deployment expectedDeployment = repository.searchBy(VERSION);
        assertThat(deployment).isEqualTo(expectedDeployment);
    }

    @Test
    void find_deployment_when_version_exists() {
        Deployment deployment = DeploymentMother.withVersion(VERSION);
        repository.save(deployment);

        Deployment expectedDeployment = repository.searchBy(VERSION);

        assertThat(deployment).isEqualTo(expectedDeployment);
    }

    @Test
    void not_find_deployment_when_version_does_not_exist() {
        Deployment deployment = DeploymentMother.withVersion(VERSION);
        repository.save(deployment);

        Deployment expectedDeployment = repository.searchBy("2.0.0");

        assertThat(expectedDeployment).isNull();
    }

    @Test
    void find_all_deployments() {
        Deployment deployment1 = DeploymentMother.withVersion("1.0.0");
        Deployment deployment2 = DeploymentMother.withVersion("2.0.0");
        repository.save(deployment1);
        repository.save(deployment2);

        List<Deployment> deployments = repository.searchAll();

        assertThat(deployments).containsExactlyInAnyOrder(deployment1, deployment2);
    }

}