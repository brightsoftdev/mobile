//
//  URLViewController.h
//  Nellodee
//
//  Created by Mai Giménez on 15/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "MainViewController.h"


@interface URLViewController : UIViewController {
    MainViewController *mainViewController;
	IBOutlet UITextField *url;
    
}


- (IBAction) saveURL; 

@property (nonatomic, retain) MainViewController *mainViewController;
@property (nonatomic, retain) IBOutlet UITextField *url;

@end
