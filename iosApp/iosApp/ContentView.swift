import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}


struct ContentView: View {
    func openComposeView() {
        let composeVC = MainViewControllerKt.MainViewController() // From KMP
        composeVC.modalPresentationStyle = .fullScreen

        // Get the top-most UIViewController
        if let windowScene = UIApplication.shared.connectedScenes.first as? UIWindowScene,
           let rootVC = windowScene.windows.first?.rootViewController {

            // If root is UINavigationController → push
            if let nav = rootVC as? UINavigationController {
                nav.pushViewController(composeVC, animated: true)
            }
            // If root is SwiftUI hosting controller or plain UIViewController → present modally
            else {
                rootVC.present(composeVC, animated: true, completion: nil)
            }
        }
    }
    var body: some View {
        NavigationView {
            VStack {
                Text("Welcome to the iOS App")
                    .padding()

                Button(action: openComposeView) {
                    Text("Open Feature View")
                        .padding()
                }
            }
            .navigationTitle("iOS App")
        }
        .navigationViewStyle(StackNavigationViewStyle())
    }
}



