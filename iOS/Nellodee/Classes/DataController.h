//
//  DataController.h
//  Nellodee
//
//  Created by Ada Hopper on 09/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface DataController : NSObject {
    NSMutableArray *categoriesList;

}
@property (nonatomic,retain) NSMutableArray *categoriesList;

- (void)loadData;
@end
