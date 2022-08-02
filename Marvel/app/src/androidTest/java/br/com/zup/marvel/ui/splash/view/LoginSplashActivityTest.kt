package br.com.zup.marvel.ui.splash.view


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import br.com.zup.marvel.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginSplashActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(SplashActivity::class.java)

    @Test
    fun loginSplashActivityTest() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.etEmailLogin),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    0
                )
            )
        )
        appCompatEditText.perform(
            scrollTo(),
            replaceText("carol@gmail.com.br"),
            closeSoftKeyboard()
        )

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.etPasswordLogin),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    1
                )
            )
        )
        appCompatEditText2.perform(scrollTo(), replaceText("12345678"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.btnLogin), withText("login"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton.perform(scrollTo(), click())

        val recyclerView = onView(
            allOf(
                withId(R.id.rvHerois),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    1
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val textView = onView(
            allOf(
                withId(R.id.tvNomeHeroiDetalhe), withText("Gamorra"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Gamorra")))

        val textView2 = onView(
            allOf(
                withId(R.id.tvHeroiDetalhe),
                withText("Gamorra foi uma personagem fict�cia que apareceu nas hist�rias em quadrinhos publicadas pela Marvel Comics. Criada por Jim Starlin, a personagem apareceu pela primeira vez em \\\"Strange Tales\\\" #180. Gamora foi a filha adotiva de Thanos, e a �ltima de sua esp�cie.\"\n"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("Gamorra foi uma personagem fict�cia que apareceu nas hist�rias em quadrinhos publicadas pela Marvel Comics. Criada por Jim Starlin, a personagem apareceu pela primeira vez em \\\"Strange Tales\\\" #180. Gamora foi a filha adotiva de Thanos, e a �ltima de sua esp�cie.\" ")))

        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Navigate up"),
                childAtPosition(
                    allOf(
                        withId(androidx.appcompat.R.id.action_bar),
                        childAtPosition(
                            withId(androidx.appcompat.R.id.action_bar_container),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val recyclerView2 = onView(
            allOf(
                withId(R.id.rvHerois),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    1
                )
            )
        )
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        val textView3 = onView(
            allOf(
                withId(R.id.tvNomeHeroiDetalhe), withText("Homem de Ferro"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("Homem de Ferro")))

        val textView4 = onView(
            allOf(
                withId(R.id.tvHeroiDetalhe),
                withText("\"O Homem de Ferro foi um personagem dos quadrinhos publicados pela Marvel Comics. Sua verdadeira identidade � o empres�rio e bilion�rio Tony Stark, que usou armaduras de alta tecnologia no combate ao crime. Foi criado em 1963 pelo escritor Stan Lee, o roteirista Larry Lieber e os desenhistas Jack Kirby e Don Heck\"\n"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("\"O Homem de Ferro foi um personagem dos quadrinhos publicados pela Marvel Comics. Sua verdadeira identidade � o empres�rio e bilion�rio Tony Stark, que usou armaduras de alta tecnologia no combate ao crime. Foi criado em 1963 pelo escritor Stan Lee, o roteirista Larry Lieber e os desenhistas Jack Kirby e Don Heck\" ")))

        val appCompatImageButton2 = onView(
            allOf(
                withContentDescription("Navigate up"),
                childAtPosition(
                    allOf(
                        withId(androidx.appcompat.R.id.action_bar),
                        childAtPosition(
                            withId(androidx.appcompat.R.id.action_bar_container),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton2.perform(click())

        val recyclerView3 = onView(
            allOf(
                withId(R.id.rvHerois),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    1
                )
            )
        )
        recyclerView3.perform(actionOnItemAtPosition<ViewHolder>(2, click()))

        val textView5 = onView(
            allOf(
                withId(R.id.tvNomeHeroiDetalhe), withText("Mulher Invis�vel"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView5.check(matches(withText("Mulher Invis�vel")))

        val textView6 = onView(
            allOf(
                withId(R.id.tvHeroiDetalhe),
                withText("A Mulher Invis�vel, alter-ego de Susan \"Sue\" Richards, � uma super-hero�na de hist�rias em quadrinhos da editora Marvel Comics. Quando foi criada e durante v�rios anos chamou-se Garota Invis�vel. No filme do Quarteto Fant�stico de 2005 foi interpretada por Jessica Alba e no de 2015, por Kate Mara."),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView6.check(matches(withText("A Mulher Invis�vel, alter-ego de Susan \"Sue\" Richards, � uma super-hero�na de hist�rias em quadrinhos da editora Marvel Comics. Quando foi criada e durante v�rios anos chamou-se Garota Invis�vel. No filme do Quarteto Fant�stico de 2005 foi interpretada por Jessica Alba e no de 2015, por Kate Mara.")))

        val appCompatImageButton3 = onView(
            allOf(
                withContentDescription("Navigate up"),
                childAtPosition(
                    allOf(
                        withId(androidx.appcompat.R.id.action_bar),
                        childAtPosition(
                            withId(androidx.appcompat.R.id.action_bar_container),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatImageButton3.perform(click())

        val overflowMenuButton = onView(
            allOf(
                withContentDescription("More options"),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.action_bar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        overflowMenuButton.perform(click())

        val textView7 = onView(
            allOf(
                withId(androidx.appcompat.R.id.title), withText("sair"),
                withParent(withParent(withId(androidx.appcompat.R.id.content))),
                isDisplayed()
            )
        )
        textView7.check(matches(withText("sair")))

        val materialTextView = onView(
            allOf(
                withId(androidx.appcompat.R.id.title), withText("sair"),
                childAtPosition(
                    childAtPosition(
                        withId(androidx.appcompat.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
