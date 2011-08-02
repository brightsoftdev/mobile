//
//  RolTableViewController.h
//  Nellodee
//
//  Created by Ada Hopper on 02/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>


@interface RolTableViewController : UITableViewController {
    NSArray *rolTypes;

}

//Should be readonly property
@property (nonatomic, retain) NSArray *rolTypes;


@end
