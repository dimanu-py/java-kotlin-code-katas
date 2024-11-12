package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.application.DeploymentSearcher;
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
public class DeploymentGetControllerShould {

    @Mock
    private DeploymentRepository deploymentRepository;

    @Test
    void find_all_deployments() {
        DeploymentSearcher deploymentSearcher = new DeploymentSearcher(deploymentRepository);
        DeploymentGetController deploymentController = new DeploymentGetController(deploymentSearcher);

        ResponseEntity<?> response = deploymentController.listAllDeployments();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(deploymentRepository).searchAll();
    }
}
