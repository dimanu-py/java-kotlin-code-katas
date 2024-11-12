package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.application.CreateDeploymentCommand;
import org.dimanu.deployservice.application.CreateDeploymentCommandMother;
import org.dimanu.deployservice.application.DeploymentCreator;
import org.dimanu.deployservice.domain.Deployment;
import org.dimanu.deployservice.domain.DeploymentMother;
import org.dimanu.deployservice.domain.DeploymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeploymentPostControllerShould {

    @Mock
    private DeploymentRepository deploymentRepository;

    @Test
    void create_a_deployment() {
        DeploymentCreator deploymentCreator = new DeploymentCreator(deploymentRepository);
        DeploymentPostController deploymentController = new DeploymentPostController(deploymentCreator);
        CreateDeploymentCommand command = CreateDeploymentCommandMother.successful();
        Deployment deployment = DeploymentMother.successful();

        ResponseEntity<?> response = deploymentController.createDeployment(command);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(deploymentRepository).save(deployment);
    }

}
