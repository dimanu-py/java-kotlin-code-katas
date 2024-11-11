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

    @Mock
    private Deployment deployment;

    @Test
    void should_create_a_deployment() {
        CreateDeploymentController deploymentController = new CreateDeploymentController();
        CreateDeploymentCommand command = CreateDeploymentCommandMother.successful();

        ResponseEntity<?> response = deploymentController.createDeployment(command);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(deploymentRepository).save(deployment);
    }

}
