package com.codurance.treasurehunting.genetic_algorithm

import com.codurance.UnitSpec
import org.mockito.BDDMockito
import org.mockito.BDDMockito.given

class RandomPopulationGeneratorShould extends UnitSpec {

	val INDIVIDUAL_1 = new Individual
	val INDIVIDUAL_2 = new Individual
	val INDIVIDUAL_3 = new Individual
	val THREE_INDIVIDUALS = 3

	val RANDOM_INDIVIDUALS = List(INDIVIDUAL_1, INDIVIDUAL_2, INDIVIDUAL_3)

	trait context {
		val randomIndividualGenerator = mock[RandomIndividualGenerator]
		val randomPopulationGenerator = new RandomPopulationGenerator(randomIndividualGenerator)
	}

	"generate a population of random individuals" in new context {
		given(randomIndividualGenerator generate())
				.willReturn (INDIVIDUAL_1, INDIVIDUAL_2, INDIVIDUAL_3)

		val population = randomPopulationGenerator populationWith THREE_INDIVIDUALS

		population should be(Population(RANDOM_INDIVIDUALS:_*))
	}

}
