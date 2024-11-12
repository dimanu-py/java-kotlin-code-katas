package org.dimanu.deployservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeployCreatorControllerShould {

    @Mock
    private DeploymentRepository deploymentRepository;

    @Test
    void create_a_deployment() {
        DeploymentCreator deploymentCreator = new DeploymentCreator(deploymentRepository);
        CreateDeploymentController deploymentController = new CreateDeploymentController(deploymentCreator);
        CreateDeploymentCommand command = CreateDeploymentCommandMother.successful();
        Deployment deployment = DeploymentMother.successful();

        ResponseEntity<?> response = deploymentController.createDeployment(command);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(deploymentRepository).save(deployment);
    }

}
