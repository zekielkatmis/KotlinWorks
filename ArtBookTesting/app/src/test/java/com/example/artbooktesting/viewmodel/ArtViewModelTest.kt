package com.example.artbooktesting.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.artbooktesting.MainCoroutineRule
import com.example.artbooktesting.getOrAwaitValue
import com.example.artbooktesting.repo.FakeArtRepository
import com.example.artbooktesting.util.Status
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArtViewModelTest {

    //Testlerde asekron işlem olmayacak (liveData gibi)
    //Her şey main threadte çalışacak

    //Threading olmadan her şeyi main threadte çalıştırayı sağlar
    @get:Rule
    var instantTestExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ArtViewModel

    @Before
    fun setup() {
        //Test Doubles (Reponun fake hali test edilir)

        viewModel = ArtViewModel(FakeArtRepository())
    }

    @Test
    fun `insert art without year returns error`() {
        viewModel.makeArt("Mona Lisa", "Da Vinci", "")
        val value = viewModel.insertArtMessage.getOrAwaitValue()
        Truth.assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without name returns error`() {
        viewModel.makeArt("", "Da Vinci", "1877")
        val value = viewModel.insertArtMessage.getOrAwaitValue()
        Truth.assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without artistName returns error`() {
        viewModel.makeArt("Mona Lisa", "", "1877")
        val value = viewModel.insertArtMessage.getOrAwaitValue()
        Truth.assertThat(value.status).isEqualTo(Status.ERROR)

    }

}